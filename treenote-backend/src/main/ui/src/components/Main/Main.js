import "./Main.css"


function Main({activeTitleId, activeContentId}){

    return (
    <div className="app-main">
        <div className="app-main-note-edit">
            <input type="text" id="title" autoFocus/>
            <textarea id="body" placeholder="Escribe tu nota aqui..."/>
        </div>
        <div className="app-main-note-preview">
                <h1 className="preview-title">{activeTitleId}</h1>
                <div className="markdown-preview">{activeContentId}</div>
        </div>
    </div>
    )
}

export default Main;