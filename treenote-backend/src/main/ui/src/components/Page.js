import React, {Component, component} from 'react'
import axios from 'axios'

class Page extends Component {
  constructor(props){
    super(props)

    this.state = {
      pages : []
    }
  }

  componentDidMount(){

    
      const pageId = this.props.match.params.id
        axios.get('http://localhost:3000/api/pages/'+pageId)
        .then(response => {
          console.log(response)
          this.setState({pages: response.data.children})
        })
        .catch(error =>{
          console.log(error)
        })
  }
  
  render(){

    const {pages} = this.state

    async function deleteNote(id){
        await axios.get('http://localhost:3000/api/notes/delete/'+id)
      .then(response => {
        console.log(response)
      })
      .catch(error =>{
        console.log(error)
      })
    }

    function deleteNoteFunction(id){
      deleteNote(id);
    }


    return(
      <div>
        <h2>Pages</h2>
        {pages.map(page => 
          <div className="app-sidebar-note">
            <div className="sidebar-note-title">
              <strong>{page.content}</strong>
              <button onClick={()=>deleteNoteFunction(page.id)}>Delete</button>
            </div>
          </div>
        )}
      </div>
    )
  }
}

export default Page;