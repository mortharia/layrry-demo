

package layrry.demo.data.provider.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.Instant;

/**
 * Data structure stored in sql data base.
 */
@Entity
@Table(name = "data")
public class Data {

    /**
     * Data's id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * Data's date.
     */
    @NotNull
    private Instant date;

    /**
     * Data's type.
     **/
    @NotNull
    private String type;


    /**
     * Data's description.
     **/
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
     * @param id the id.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the start date.
     *
     * @return the start date.
     */
    public Instant getDate() {
        return date;
    }

    /**
     * Set the start date.
     *
     * @param date the start date.
     */
    public void setDate(Instant date) {
        this.date = date;
    }

    /**
     * Get the impact.
     *
     * @return the impact.
     */
    public String getType() {
        return type;
    }

    /**
     * Set the impact.
     *
     * @param type the impact.
     */
    public void setType(String type) {
        this.type = type;
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
     * @param description the description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
