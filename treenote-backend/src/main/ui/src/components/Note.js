// import {MdDelete} from 'react-icons/md'

const Note = () => {
    return(
        <div className='note'>
            <span>My first Note!</span>
            <div className="note-footer">
                <small>19/10/2021</small>
                {/* <MdDelete className='delete-icon' size='1.3em'/> */}
            </div>
        </div>
    )
};

export default Note;