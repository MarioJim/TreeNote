import React, {Component, component, useState} from 'react'
import axios from 'axios'
import {Main} from './Main/Main'

class Page extends Component {
  constructor(props){
    super(props)

    this.state = {
      pages : [],
      activeNote : -1
    }

    this.delta = this.delta.bind(this);
  }

    delta(id) {
      this.setState({
          activeNote : id
      });
  }

  componentDidMount(){
      const bookId = parseInt(this.props.match.params.id)
      axios.get('http://localhost:3000/api/books/')
      .then(response => {
        response.data.map(book =>
          {if(book.id == bookId){
            this.setState({pages : book.pages})
          }}
        )
      })
      .catch(error =>{
        console.log(error)
      })
  }
  
  render(){

    const {pages, activeNote} = this.state

    async function deleteNote(id){
        await axios.get('http://localhost:3000/api/pages/delete/'+id)
      .then(response => {
        window.location.reload()
      })
      .catch(error =>{
        console.log(error)
      })
    }

    function setActiveNote(page, activeNote){
      // console.log(page.content)
      const titleId = page.id
      const titleContent = page.content
      // console.log(titleId, titleContent)

      if(page.length>0){
        const notaId = page.children[0].id
        const notaContent = page.children[0].content
        activeNote(titleId, titleContent, notaId, notaContent)
      }
      else{
        console.log("no hay nota guardada")
      }
    }

    return(
      <div>
        <h2>Pages</h2>
        {pages.map(page => 
          <div className={`app-sidebar-note ${page.id === activeNote && "active"}`} onClick={()=> {setActiveNote(page, this.props.activeNote); this.delta(page.id)}}>
            <div className="sidebar-note-title">
              <strong>{page.title}</strong>
              <button onClick={()=>deleteNote(page.id)}>Delete</button>
            </div>
          </div>
        )}
      </div>
    )
  }
}

export default Page;