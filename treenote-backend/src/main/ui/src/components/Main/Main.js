import "./Main.css"


function Main({titleId, titleContent, noteId, noteContent}){


    // const updateTitle = (titleId, newTitle) =>{
    //     const noteTitle = {parent_id: parentId, note_type : "TextNote", content : "Untitle Note"}
    //     axios.post('http://localhost:3000/api/notes/new', noteTitle)
    //     .then(response => window.location.reload())
    // }

    // const updateNote = (NoteId, newNote) =>{
        
    // }

    const updateData = () =>{
        console.log(document.getElementById('title').value)
        console.log(document.getElementById('body').value)
    }

    if(titleId===-1){
        return <div className='no-active-note'>Nota no seleccionada</div>
    }

    return (
    <div className="app-main">
        <div className="app-main-note-edit">
            <input type="text" id="title" placeholder={titleContent} autoFocus/>
            <textarea id="body" placeholder="Escribe tu nota aqui..."dock/>
            <button onClick={()=> {updateData()}}>Save note</button>
        </div>
        <div className="app-main-note-preview">
                <h1 className="preview-title">{titleContent}</h1>
                <div className="markdown-preview">{noteContent}</div>
        </div>
    </div>
    )
}

export default Main;