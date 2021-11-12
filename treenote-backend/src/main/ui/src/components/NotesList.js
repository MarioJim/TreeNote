import Note from './Note'
import { useState } from 'react';
import {nanoid} from 'nanoid'

const NotesList = () => {
    const [notes, setNotes] = useState([
        {
        id: nanoid(),
        text : "My first note!",
        date: "24/10/21",
        },
        {
            id: nanoid(),
            text : "My second note!",
            date: "24/10/21",
        },
        {
            id: nanoid(),
            text : "third note!",
            date: "10/11/21"
        }
    ]);

    return (
        <div className='notes-list'>
            {notes.map((note)=> (
                <Note id={note.id} text={note.text} date={note.date}/>
            ))}
        </div>
    );
};

export default NotesList;