package org.jabref.model.study;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudyQuery {
    private String query;
    @JsonProperty("library-specific-query-refinements")
    private Map<String, String> librarySpecificQueryRefinements;


    public StudyQuery(String query) {
        this.query = query;
    }

    /**
     * Used for Jackson deserialization
     */
    public StudyQuery() {

    }

    public String getBaseQuery() {
        return query;
    }

    public String getLibrarySpecificQuery(String libraryName) {
        return librarySpecificQueryRefinements.getOrDefault(libraryName, query);
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setLibrarySpecificQueryRefinements(Map<String, String> queryRefinements) {
        this.librarySpecificQueryRefinements = queryRefinements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StudyQuery that = (StudyQuery) o;

        return getBaseQuery() != null ? getBaseQuery().equals(that.getBaseQuery()) : that.getBaseQuery() == null;
    }

    @Override
    public int hashCode() {
        return getBaseQuery() != null ? getBaseQuery().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "QueryEntry{" +
                "query='" + query + '\'' +
                '}';
    }
}
