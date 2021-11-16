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
        <p>asdhkashdjkasd</p> 
      </div>
    )
  }
}

export default Page;