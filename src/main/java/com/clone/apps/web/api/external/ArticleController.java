package com.clone.apps.web.api.external;

import com.clone.apps.web.api.Article;
import com.clone.apps.web.api.ExternalContextController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kh.jin on 2019. 10. 24.
 */
@RestController
public class ArticleController implements ExternalContextController {
    private final Logger log = LoggerFactory.getLogger(ArticleController.class);

    private List<Article> articles;

    @PostConstruct
    public void setup() {
        articles = new ArrayList<>();
        articles.add(new Article(1,"A"));
        articles.add(new Article(2,"B"));
        articles.add(new Article(3,"C"));
    }


    @GetMapping(value = "/articles/{id}")
    public Article getArticle(@PathVariable int id) {
        return articles.get(id);
    }


}