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
    console.log(pages)

    return(
      <div>
        <h2>Pages</h2>
        {pages.map(page => 
          <div className="app-sidebar-note">
            <div className="sidebar-note-title">
              <strong>{page.content}</strong>
              <button>Delete</button>
            </div>
          </div>
        )}
      </div>
    )
  }
}

export default Page;