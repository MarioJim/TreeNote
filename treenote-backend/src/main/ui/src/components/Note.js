import {MdDelete} from 'react-icons/md'


const Note = ({id, text, date}) => {
    return(
        <div className='note'>
            <span>{text}</span>
            <div className="note-footer">
                <small>{date}</small>
                <MdDelete className='delete-icon' size='1.3em'/>
            </div>
        </div>
    )
};

export default Note;