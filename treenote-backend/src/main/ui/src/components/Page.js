import React, {Component, component} from 'react'
import axios from 'axios'

class Page extends Component {
  constructor(props){
    super(props)

    this.state = {
      pages : []
    }
  }

  async componentDidMount(){

    if(this.props.match.params.id){
      const pageId = this.props.match.params.id
        axios.get('http://localhost:3000/api/pages/'+pageId)
        .then(response => {
          console.log(response)
          this.setState({pages: response.data})
        })
        .catch(error =>{
          console.log(error)
        })
    }
  }
  
  render(){

    const {pages} = this.state 
    console.log(pages)

    return(
      <div>
        <h2>Pages</h2>
        {/* <p>{pages.id}</p>
        {pages.map(page => 
          <div className="app-sidebar-note">
            <div className="sidebar-note-title">
              <strong>{page.id}</strong>
              <button>Delete</button>
            </div>
          </div>
        )} */}
      </div>
    )
  }
}

export default Page;