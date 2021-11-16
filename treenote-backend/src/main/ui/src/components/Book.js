import React, {Component, component} from 'react'
import axios from 'axios'
import Note from './Note'

class Book extends Component {
  constructor(props){
    super(props)
    
    this.state = {
      pages : []
    }

  }

  componentDidMount(){
    axios.get('http://localhost:3000/api/books/')
    .then(response => {
      console.log(response)
      this.setState({pages: response.data})
    })
    .catch(error =>{
      console.log(error)
    })
  }
  
  render(){
    const {pages} = this.state
    
    return(
      
      <div>
        <div className="app-sidebar-note">
          <div className="sidebar-note-title">
            <strong>TITLE</strong>
            <button>Delete</button>
          </div>
          <p>Note preview</p>
        </div>
      </div>
    )
  }
}

export default Book;