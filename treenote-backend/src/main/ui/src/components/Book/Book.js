import React, {Component, component} from 'react'
import axios from 'axios'
import "./Book.css"

class Book extends Component {
  constructor(props){
    super(props)
    
    this.state = {
      books : []
    }

  }

  componentDidMount(){
    axios.get('http://localhost:3000/api/books/')
    .then(response => {
      console.log(response)
      this.setState({books: response.data})
    })
    .catch(error =>{
      console.log(error)
    })
  }

  
  render(){
    const {books} = this.state
    
    async function addBook(title){
      console.log("adding my book", title)
    }

    async function deleteBook(id){
        await axios.get('http://localhost:3000/api/books/delete/'+id)
      .then(response => {
        console.log(response)
      })
      .catch(error =>{
        console.log(error)
      })
    }

    function deleteBookFunction(id){
      deleteBook(id);
    }

    return(
      
      <div>
        {books.map(book => 
        <div>
            <div className="app-sidebar-note" onClick={()=> this.props.history.push('/pages/'+book.pages[0].id)}>
              <div className="sidebar-note-title" >
                <strong>{book.title}</strong>
              </div>
            </div>
            <button onClick={()=>deleteBookFunction(book.id)}>Delete</button>
        </div>
        )}
      </div>
    )
  }
}

export default Book;