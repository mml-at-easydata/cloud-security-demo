package cn.lilq.cloudsecurity.cloudbookserver.entity;

/**
 * @auther: Li Liangquan
 * @date: 2020/10/31 14:07
 */

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Tab_Book")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Book {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;
    @Column
    private String name;
    @Column
    private String category;//类别
    @Column
    private Integer repertory;//库存

    public Book(String id, String name, String category, Integer repertory) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.repertory = repertory;
    }

    public Book() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getRepertory() {
        return repertory;
    }

    public void setRepertory(Integer repertory) {
        this.repertory = repertory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(name, book.name) &&
                Objects.equals(category, book.category) &&
                Objects.equals(repertory, book.repertory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, repertory);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", repertory=" + repertory +
                '}';
    }
}
