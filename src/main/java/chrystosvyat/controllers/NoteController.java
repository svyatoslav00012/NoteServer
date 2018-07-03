package chrystosvyat.controllers;

import chrystosvyat.model.Note;
import chrystosvyat.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class NoteController {

	@Autowired
	NoteService service;

	@GetMapping("/note/{id}")
	public Note getNoteById(@PathVariable(value = "id") Long noteId){
		return service.findById(noteId);
	}

	@GetMapping("/notes")
	public List<Note> getAllNotes(){
		return service.getAllNotes();
	}

	@PostMapping("/note")
	public Note addNote(Note note){
		return service.addNote(note);
	}

	@DeleteMapping("/note/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId){
		service.deleteById(noteId);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/note/{id}")
	public Note updateNote(@PathVariable(value = "id") Long noteId,
						   Note noteDetails){
		System.out.println("update");
		return service.update(noteId, noteDetails);
	}
}
