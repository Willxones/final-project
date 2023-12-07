package com.project.server.league;

import com.project.server.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeagueRepository extends JpaRepository<League, Long> {

}
