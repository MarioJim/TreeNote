import React, {Component, component} from 'react'
import axios from 'axios'
import Note from './Note'
import { Tree } from 'antd';
import Sidebar from './sidebar/sidebar'

class Page extends Component {
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
        <Sidebar></Sidebar>
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

export default Page;