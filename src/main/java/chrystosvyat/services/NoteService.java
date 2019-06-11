package chrystosvyat.services;

import chrystosvyat.model.Note;
import chrystosvyat.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

	@Autowired
	NoteRepository noteRepository;

	public Note findById(Long noteId) {
		return noteRepository.findById(noteId).get();
	}

	public List<Note> getAllNotes() {
		return noteRepository.findAll();
	}

	public Note addNote(Note note) {
		return noteRepository.save(note);
	}

	public void deleteById(Long noteId){
		//Note n = noteRepository.findById(noteId).orElseThrow(()-> new Exception());
		noteRepository.deleteById(noteId);
	}

	public void deleteAll(){
		noteRepository.deleteAll();
	}

	public Note update(Long noteId, Note noteDetails) {
//		Note n = noteRepository.findById(noteId).get();
//		n.setTopic(noteDetails.getTopic());
//		n.setContent(noteDetails.getContent());
		noteDetails.setId(noteId);
		return noteRepository.save(noteDetails);
	}
}
