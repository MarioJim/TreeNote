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
        <div className='page-box'>
          <div className='page-title'>Arquitectura de Software</div>
          <div className='notes-list'>
          {pages.map(page => <Note id={page.id} text={page.title} date={page.id}/>)}
          </div>
        </div>
      </div>

    )
  }
}

export default Book;