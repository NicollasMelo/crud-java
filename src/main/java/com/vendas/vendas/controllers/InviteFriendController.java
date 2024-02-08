package com.vendas.vendas.controllers;

import com.vendas.vendas.models.InviteFriendModel;
import com.vendas.vendas.repositories.InviteFriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class InviteFriendController {

    @Autowired
    private InviteFriendRepository repository;

    @GetMapping("/convidar")
    public ResponseEntity<List<InviteFriendModel>> getFriends() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @GetMapping("/convidar/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") int id) {
        Optional<InviteFriendModel> friendModel = repository.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(friendModel.get());
    }

    @PostMapping("/convidar")
    public ResponseEntity<InviteFriendModel> createFriend(@RequestBody InviteFriendModel friend) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(friend));
    }

    @PutMapping("/convidar/{id}")
    public ResponseEntity<Object> updateFriend(@PathVariable(value = "id") int id, @RequestBody InviteFriendModel friend) {
        Optional<InviteFriendModel> friendOptional = repository.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(friend));
    }

    @DeleteMapping("/convidar/{id}")
    public ResponseEntity<Object> deleteFriend(@PathVariable(value = "id") int id) {
        Optional<InviteFriendModel> friendOptional = repository.findById(id);
        repository.delete(friendOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!");
    }
}