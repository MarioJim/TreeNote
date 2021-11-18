import axios from "axios"
import "./Main.css"


function Main({titleId, titleContent, noteId, noteContent}){


    async function addNote(id, content){
        console.log("adding note")
        const note = {parent_id: parseInt(id)-1, note_type: "TextNote", content: content}
        axios.post('http://localhost:3000/api/notes/new', note)
        .then(response => window.location.reload())
    }

    const updateData = (titleId, noteId) =>{

<<<<<<< HEAD
    async function addNote(id, content){
        const note = {parent_id: parseInt(id)-1, note_type: "TextNote", content: content}
        axios.post('http://localhost:3000/api/notes/new', note)
        .then(response => window.location.reload())
    }

    const updateData = (titleId, noteId) =>{

        var title = document.getElementById('title').value
        var note = document.getElementById('body').value
        
        if(!title){
            title = titleContent
        }
        if(!note){
            note = noteContent
        }

        //Delete page
        axios.get('http://localhost:3000/api/pages/delete/'+titleId)
        
        var bookId = parseInt(document.URL.split(/[/ ]+/).pop());
        
        const page = {book_id: bookId, title : title}
        axios.post('http://localhost:3000/api/pages/new', page)
        .then(response => addNote(response.data.id, note))
    }

=======
        var title = document.getElementById('title').value
        var note = document.getElementById('body').value
        
        if(!title){
            title = titleContent
        }
        if(!note){
            note = noteContent
        }

        //Delete page
        axios.get('http://localhost:3000/api/pages/delete/'+titleId)
        
        var bookId = parseInt(document.URL.split(/[/ ]+/).pop());
        
        const page = {book_id: bookId, title : title}
        axios.post('http://localhost:3000/api/pages/new', page)
        .then(response => addNote(response.data.id, note))
    }

>>>>>>> origin/main
    if(titleId===-1 ){
        return <div className='no-active-note'>Nota no seleccionada</div>
    }

    return (
    <div className="app-main">
        <div className="app-main-note-edit">
            <input type="text" id="title" placeholder={titleContent} autoFocus/>
            <textarea id="body" placeholder={noteContent}/>
<<<<<<< HEAD
            <button  onClick={()=> {updateData(titleId, noteId)}} className="saveButton">Save note</button>
=======
            <button onClick={()=> {updateData(titleId, noteId)}}>Save note</button>
>>>>>>> origin/main
        </div>
        <div className="app-main-note-preview">
                <h1 className="preview-title">{titleContent}</h1>
                <div className="markdown-preview">{noteContent}</div>
        </div>
    </div>
    )
}

export default Main;