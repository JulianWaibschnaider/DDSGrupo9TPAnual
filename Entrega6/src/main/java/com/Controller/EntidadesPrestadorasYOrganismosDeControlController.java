package com.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import com.Clases.Model.Shared.LlenadorDeCSV;

import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin
public class EntidadesPrestadorasYOrganismosDeControlController {
	@PostMapping(path = "EntidadesYOrganismos/ImportarCSV")
	public ResponseEntity<String> CrearIncidente(@RequestParam("csv") MultipartFile file) {
        List<String> entidadesPrestadorasYOrganismosDeControl = new ArrayList<String>();
        try {          
            entidadesPrestadorasYOrganismosDeControl = Arrays.asList(new String(file.getBytes()).split("\n"));
            LlenadorDeCSV.llenarEntidadesYOrganismos(entidadesPrestadorasYOrganismosDeControl);
            return ResponseEntity.ok("CSV import successful!");
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error processing CSV: " + e.getMessage());
        }
	}
}
