import React, {Component, component, useState} from 'react'
import axios from 'axios'
import {Main} from './Main/Main'

class Page extends Component {
  constructor(props){
    super(props)

    this.state = {
      pages : [],
      activeNote : -1,
      content : []
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
            if(book.pages[0].title=='New Page'){
              const note = {parent_id: parseInt(book.pages[0].id)-1, note_type: "TextNote", content: "new note"}
              axios.post('http://localhost:3000/api/notes/new', note)
              .then(response => response.data)
            }
            this.setState({pages : book.pages})
          }}
        )
      })
      .catch(error =>{
        console.log(error)
      })

  }
  
  render(){

    const {pages, activeNote, content} = this.state

    async function deleteNote(id){
        await axios.get('http://localhost:3000/api/pages/delete/'+id)
      .then(response => {
        window.location.reload()
      })
      .catch(error =>{
        console.log(error)
      })
    }


    async function getNote(pageId){
      pageId = parseInt(pageId)
      const res = await axios.get('http://localhost:3000/api/pages/'+pageId)
      return res.data
    }


    function setActiveNote(page, activeNote){
      // console.log(page.content)
      const titleId = page.id
      const title = page.title
      
      getNote(titleId).then(data =>{

        try{
          console.log(titleId, title, data.children[0].id, data.children[0].content)
        }
        catch{
          
          window.location.reload()
        }
        
      })
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