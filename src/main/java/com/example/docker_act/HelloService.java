package com.example.docker_act;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HelloService {
    private final HelloRepository helloRepository;

    public void cHello(HelloRequestDto helloRequestDto) {
        HelloEntity helloEntity = new HelloEntity(helloRequestDto.getName());
        helloRepository.save(helloEntity);
    }

    public String rHello() {
        List<HelloEntity> helloEntities = helloRepository.findAll();

        String result = helloEntities.stream()
                .map(helloEntity -> "Id: " + helloEntity.getId() + ", Name: " + helloEntity.getName())
                .collect(Collectors.joining("\n"));

        return result;
    }
}
