import React, {Component, component} from 'react'
import axios from 'axios'
import Note from './Note'
import { Tree } from 'antd';
import Sidebar from './sidebar/sidebar'

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
        {pages.map(page=> <div className='page-box'>
          <div className='page-title'>{page.id} {page.title}</div>
        </div>)}
      </div>
    )
  }
}

export default Book;