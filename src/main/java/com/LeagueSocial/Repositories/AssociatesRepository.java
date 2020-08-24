package com.LeagueSocial.Repositories;

import com.LeagueSocial.Domain.Associates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface AssociatesRepository extends JpaRepository<Associates, Integer> {
    //qual o problema dessa query???
    @Query("select obj From Associations obj where obj.user.id = :id")
   public List<Associates> AllFollow(@Param("id") Integer id);

    @Query("select obj From Associations obj where obj.target.id = :id")
   public List<Associates> AllFollowMe(@Param("id") Integer id);


    @Query(value = "select * From Associations ass where ass.pk_user = :user and ass.pk_target = :target", nativeQuery = true)
    public Optional<Associates> SelectLine(@Param("user") Integer user, @Param("target") Integer target);

    //@Transactional
    //@Modifying
    @Query(value = "delete from Associations as obj where obj.pk_user = :user and obj.pk_target = :target", nativeQuery = true)
    public void DeleteAssociate(@Param("user") Integer user, @Param("target") Integer target);


}
