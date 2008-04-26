package org.remast.baralga.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("project") //$NON-NLS-1$
public class Project implements Serializable, Comparable<Project>{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private final long id;
    
    private final String title;
    
    private String description;
    
    public Project(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return getTitle();
    }
    
    @Override
    public boolean equals(Object that) {
        if ( this == that ) 
            return true;
        
        if (that == null || !(that instanceof Project))
            return false;
        
        final Project project = (Project) that;
        
        final EqualsBuilder eqBuilder = new EqualsBuilder();
        eqBuilder.append(this.getId(), project.getId());
        return eqBuilder.isEquals();
    }

    public int compareTo(Project project) {
        if (project == null || this.getTitle() == null) {
            return 0;
        }
        
        // Sort by title.
        return this.getTitle().compareTo(project.getTitle());
    }
}
