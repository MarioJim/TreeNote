const AddNote = () => {
    return(
    <div className="note new">
        <textarea 
        rows="8" 
        cols="10" 
        placeholder='Type to add a note'></textarea>
        <button className='save'>Save</button>
    </div>
    )
}