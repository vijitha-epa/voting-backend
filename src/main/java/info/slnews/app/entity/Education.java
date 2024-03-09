package info.slnews.app.entity;

import info.slnews.app.enums.QualificationStatus;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "qualification", length = 100, nullable = false)
    private String qualification;

    @Column(name = "institution", length = 100, nullable = false)
    private String institution;

    @Column(name = "commencedOn")
    private Instant commencedOn;

    @Column(name = "endDate")
    private Instant endedOn;

    @Column(name = "status", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private QualificationStatus status;

    @Column(name = "description", length = 250)
    private String description;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    public Education() {
    }

    public Education(Long id, String qualification, String institution, Instant commencedOn, Instant endedOn,
                     QualificationStatus status,
                     String description, Long memberId) {
        this.id = id;
        this.qualification = qualification;
        this.institution = institution;
        this.commencedOn = commencedOn;
        this.endedOn = endedOn;
        this.status = status;
        this.description = description;
        this.memberId = memberId;
    }

    public Long getId() {
        return id;
    }

    public String getQualification() {
        return qualification;
    }

    public String getInstitution() {
        return institution;
    }

    public Instant getCommencedOn() {
        return commencedOn;
    }

    public QualificationStatus getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public Instant getEndedOn() {
        return endedOn;
    }

    public Long getMemberId() {
        return memberId;
    }
}
