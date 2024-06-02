package com.printingservice.repositories;

import com.printingservice.models.UserCredential;
import java.util.Optional;

public interface UserCredentialRepository extends BaseRepository<UserCredential, Long> {
  Optional<UserCredential> findByUsername(String username);

  Boolean existsByUsername(String username);
}
