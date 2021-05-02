
package layrry.demo.rest.api.model;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Base class for entity objects with an ID, a Name and a description.
 */
@MappedSuperclass
public abstract class AbstractNamedDataObject  {
    /**
     * The id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Object name.
     */
    private String name;
    /**
     * Object description.
     */
    private String description;

    /**
     * Get the id.
     *
     * @return the id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the id.
     *
     * @param id  the id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the name.
     *
     * @return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name.
     *
     * @param name  the name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the description.
     *
     * @return the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description.
     *
     * @param description  the description.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
