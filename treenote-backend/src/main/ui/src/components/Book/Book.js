import React, {Component, component} from 'react'
import axios from 'axios'
import "./Book.css"

class Book extends Component {
  constructor(props){
    super(props)
    
    this.state = {
      books : [],
      activeBook : -1
    }
    this.delta = this.delta.bind(this);
  }

    delta(id) {
      this.setState({
          activeBook : id
      });
  }

  componentDidMount(){
    axios.get('http://localhost:3000/api/books/')
    .then(response => {
      this.setState({books: response.data})
    })
    .catch(error =>{
      console.log(error)
    })
  }

  
  render(){
    const {books, activeBook} = this.state
    
    async function addBook(title){
      console.log("adding my book", title)
    }

    async function deleteBook(id){
        await axios.get('http://localhost:3000/api/books/delete/'+id)
      .then(response => {
        window.location.reload()
      })
      .catch(error =>{
        console.log(error)
      })
    }

    function deleteBookFunction(id){
      deleteBook(id);
    }

    function setActiveBook(book){
      const bookId = book.id
      const bookTitle = book.title

      if(document.getElementById('bookName').value){
        const newTitle = document.getElementById('bookName').value
        const newBook = { id : bookId, title : newTitle}
        axios.post('http://localhost:3000/api/books/update', newBook)
        .then(response => window.location.reload())
      }
    }


    return(

      <div> 
        {books.map(book => 
            <div key={book.id} className={`app-sidebar-note ${book.id === activeBook && "active"}`} onClick={()=> {this.delta(book.id)}}>
              <div className="sidebar-note-title" >
                <strong onClick={()=> this.props.history.push('/pages/'+book.id)}>{book.title}</strong>
                <button onClick={()=>setActiveBook(book)} className="editButton">Edit</button>
                <button onClick={()=>deleteBookFunction(book.id)} className="deleteButton">Delete</button>
              </div>
            </div>
        )}
      </div>
    )
  }
}

export default Book;