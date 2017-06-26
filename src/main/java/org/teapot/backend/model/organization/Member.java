package org.teapot.backend.model.organization;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.teapot.backend.model.user.User;
import org.teapot.backend.util.deser.MemberDeserializer;
import org.teapot.backend.util.ser.MemberSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "organization_member")
@JsonSerialize(using = MemberSerializer.class)
@JsonDeserialize(using = MemberDeserializer.class)
public class Member implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @Enumerated
    private MemberStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Organization organization;

    @Column(name = "admission_date")
    private LocalDate admissionDate;

    public Member() {
    }

    public Member(Long id,
                  User user,
                  MemberStatus status,
                  Organization organization,
                  LocalDate admissionDate) {
        this.id = id;
        this.user = user;
        this.status = status;
        this.organization = organization;
        this.admissionDate = admissionDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MemberStatus getStatus() {
        return status;
    }

    public void setStatus(MemberStatus status) {
        this.status = status;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }
}