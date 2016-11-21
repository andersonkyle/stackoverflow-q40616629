package com.example.stackoverflow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StackOverflowQ40616629ApplicationTests {

	@Autowired
	private PostRepository postRepository;

	@Transactional
	@Test
	public void orderByDays() {
		Post p1 = new Post();
		p1.setTitle("POST1");
		p1.setSourceUrl("POST1");
		p1.setPublishedOn(LocalDateTime.of(2016, 11, 13, 00, 00));

		Post p2 = new Post();
		p2.setTitle("POST2");
		p2.setSourceUrl("POST2");
		p2.setPublishedOn(LocalDateTime.of(2016, 11, 12, 00, 00));

		Post p3 = new Post();
		p3.setTitle("POST3");
		p3.setSourceUrl("POST3");
		p3.setPublishedOn(LocalDateTime.of(2016, 11, 11, 00, 00));

		postRepository.save(Arrays.asList(p1, p2, p3));

		List<Post> posts = postRepository.findAllByOrderByPublishedOnDesc();

		assertTrue(posts.get(0).getPublishedOn().isAfter(posts.get(1).getPublishedOn()));
		assertTrue(posts.get(1).getPublishedOn().isAfter(posts.get(2).getPublishedOn()));
	}

	@Transactional
	@Test
	public void orderByMinutes(){
		Post p1 = new Post();
		p1.setTitle("POST1");
		p1.setSourceUrl("POST1");
		p1.setPublishedOn(LocalDateTime.of(2016, 11, 13, 01, 03));

		Post p2 = new Post();
		p2.setTitle("POST2");
		p2.setSourceUrl("POST2");
		p2.setPublishedOn(LocalDateTime.of(2016, 11, 13, 01, 02));

		Post p3 = new Post();
		p3.setTitle("POST3");
		p3.setSourceUrl("POST3");
		p3.setPublishedOn(LocalDateTime.of(2016, 11, 13, 01, 01));

		postRepository.save(Arrays.asList(p1, p2, p3));

		List<Post> posts = postRepository.findAllByOrderByPublishedOnDesc();

		assertTrue(posts.get(0).getPublishedOn().isAfter(posts.get(1).getPublishedOn()));
		assertTrue(posts.get(1).getPublishedOn().isAfter(posts.get(2).getPublishedOn()));
	}

}
