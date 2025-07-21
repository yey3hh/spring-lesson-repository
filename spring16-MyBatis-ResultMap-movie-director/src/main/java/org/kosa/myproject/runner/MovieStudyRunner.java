package org.kosa.myproject.runner;

import org.kosa.myproject.domain.Director;
import org.kosa.myproject.domain.Movie;
import org.kosa.myproject.mapper.MovieMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MovieStudyRunner implements CommandLineRunner {
	private final MovieMapper movieMapper;

	public MovieStudyRunner(MovieMapper movieMapper) {
		super();
		this.movieMapper = movieMapper;
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("MovieStudyRunner " + movieMapper);
		
		// 1. 총 영화 수 조회
//		int movieCount = movieMapper.getTotalCount();
//		System.out.println("총 영화 수 : " + movieCount);
		
		// 2. 영화 (감독 정보 포함) 리스트 조회
//		List<Movie> list = movieMapper.findMovieList();
//		for (Movie movie : list) {
//			// Movie has a Director 정보가 잘 조회되는 지를 테스
//			System.out.println(movie.getMovieId()+ " " + movie.getTitle() + " " + movie.getdirector().getDirectorName() + " " + movie.getdirector().getDirectorId());
//		}
		
		// 3. 영화 상세 정보 조회 (영화 정보와 감독 정보를 상세히 페이지 보여주기 위함)
//		Long movieId = 1L;
//		Movie detailMovie = movieMapper.findMovieById(movieId);
//		System.out.println(detailMovie);
		
		// 4. 영화 정보를 등록
		Director director = new Director();
		director.setDirectorId(1L);
		Movie movie = new Movie("살인의추억", "스릴러", 1000L, director);
		int insertResult = movieMapper.register(movie);
		System.out.println("영화 등록 OK " + insertResult);
	}

}
