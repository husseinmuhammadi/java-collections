package com.javastudio.tutorial.collections;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeTest {

    @Test
    void should_return_posts_in_last_5_minute() {
        SortedSet<Post> sortedPosts = new TreeSet<>();

        // Simulate adding posts
        sortedPosts.add(new Post("Title 1", "Description 1", Instant.now()));
        sortedPosts.add(new Post("Title 2", "Description 2", Instant.now().minusSeconds(120)));
        sortedPosts.add(new Post("Title 3", "Description 3", Instant.now().minusSeconds(240)));
        sortedPosts.add(new Post("Title 4", "Description 4", Instant.now().minusSeconds(720)));

        // Calculate the cutoff time (10 minutes ago)
        Instant cutoffTime = Instant.now().minus(Duration.ofSeconds(300));

        // Retrieve recent posts
        Set<Post> recentPosts = sortedPosts.tailSet(new Post("", "", cutoffTime));

        // Display recent posts
        System.out.println("Recent Posts:");
        for (Post post : recentPosts) {
            System.out.println(post);
        }
    }
}

record Post(String title, String description, Instant timestamp) implements Comparable<Post> {
    @Override
    public int compareTo(Post other) {
        return this.timestamp.compareTo(other.timestamp);
    }
}
