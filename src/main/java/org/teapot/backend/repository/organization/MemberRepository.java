package org.teapot.backend.repository.organization;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.teapot.backend.model.organization.Member;
import org.teapot.backend.model.organization.MemberStatus;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @RestResource(path = "find-by-status")
    Page<Member> findByStatus(@Param("status") MemberStatus status, Pageable pageable);

    @RestResource(path = "find-by-organization-id-and-status")
    Page<Member> findByOrganizationIdAndStatus(@Param("organizationId") Long organizationId, @Param("status") MemberStatus status, Pageable pageable);

    @RestResource(path = "find-by-organization-name-and-status")
    Page<Member> findByOrganizationNameAndStatus(@Param("organizationName") String organizationName, @Param("status") MemberStatus status, Pageable pageable);

    @RestResource(path = "find-by-user-id-and-status")
    Page<Member> findByUserIdAndStatus(@Param("userId") Long userId, @Param("status") MemberStatus status, Pageable pageable);

    @RestResource(path = "find-by-user-name-and-status")
    Page<Member> findByUserNameAndStatus(@Param("userName") String userName, @Param("status") MemberStatus status, Pageable pageable);

    @RestResource(path = "find-by-user-email-and-status")
    Page<Member> findByUserEmailAndStatus(@Param("userEmail") String userEmail, @Param("status") MemberStatus status, Pageable pageable);

    @RestResource(path = "find-by-organization-id")
    Page<Member> findByOrganizationId(@Param("organizationId") Long organizationId, Pageable pageable);

    @RestResource(path = "find-by-organization-name")
    Page<Member> findByOrganizationName(@Param("organizationName") String organizationName, Pageable pageable);

    @RestResource(path = "find-by-user-id")
    Page<Member> findByUserId(@Param("userId") Long userId, Pageable pageable);

    @RestResource(path = "find-by-user-name")
    Page<Member> findByUserName(@Param("userName") String userName, Pageable pageable);

    @RestResource(path = "find-by-user-email")
    Page<Member> findByUserEmail(@Param("userEmail") String userEmail, Pageable pageable);

    @RestResource(path = "find-by-id-and-organization-id")
    Member findByIdAndOrganizationId(@Param("id") Long id, @Param("organizationId") Long organizationId);

    @RestResource(path = "find-by-id-and-organization-name")
    Member findByIdAndOrganizationName(@Param("id") Long id, @Param("organizationName") String organizationName);

    @RestResource(path = "find-by-organization-id-and-user-id")
    Member findByOrganizationIdAndUserId(@Param("organizationId") Long organizationId, @Param("userId") Long userId);

    @RestResource(path = "find-by-organization-name-and-user-id")
    Member findByOrganizationNameAndUserId(@Param("organizationName") String organizationName, @Param("userId") Long userId);

    @RestResource(path = "find-by-organization-id-and-user-name")
    Member findByOrganizationIdAndUserName(@Param("organizationId") Long organizationId, @Param("userName") String userName);

    @RestResource(path = "find-by-organization-id-and-user-email")
    Member findByOrganizationIdAndUserEmail(@Param("organizationId") Long organizationId, @Param("userEmail") String userEmail);

    @RestResource(path = "find-by-organization-name-and-user-name")
    Member findByOrganizationNameAndUserName(@Param("organizationName") String organizationName, @Param("userName") String userName);

    @RestResource(path = "find-by-organization-name-and-user-email")
    Member findByOrganizationNameAndUserEmail(@Param("organizationName") String organizationName, @Param("userEmail") String userEmail);
}
