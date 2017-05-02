/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

/**
 *
 * @author pqkallio
 */
public class QueryBuilder {
    Matcher matcher;

    public QueryBuilder() {
    }
    
    public Matcher build() {
        Matcher m = this.matcher;
        this.matcher = null;
        return m;
    }
    
    public QueryBuilder playsIn(String team) {
        createAndMatcher(new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int amount, String category) {
        createAndMatcher(new HasAtLeast(amount, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int amount, String category) {
        createAndMatcher(new HasFewerThan(amount, category));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        this.matcher = new Or(matchers);
        return this;
    }
    
    private void createAndMatcher(Matcher matcher) {
        if (this.matcher == null) {
            this.matcher = matcher;
        } else {
            this.matcher = new And(this.matcher, matcher);
        }
    }
}
