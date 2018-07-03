package chrystosvyat.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "note")
@Data
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "topic")
	private String topic;

	@Column(name = "content")
	private String content;

}
