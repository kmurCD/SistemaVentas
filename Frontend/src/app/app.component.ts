import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { FormBuilder, FormGroup,Validators } from '@angular/forms';
import { CiudadService } from './services/ciudad/ciudad.service';
import { PaisesService } from './services/paises/paises.service';
import { PersonaService } from './services/persona/persona.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'Frontend';
  
  personaForm: FormGroup;

  constructor(
    
    public fb: FormBuilder,
    public ciudadService: CiudadService,
    public paisesService: PaisesService,
    public personaService: PersonaService
    ){}
  ngOnInit(): void {
    this.personaForm =this.fb.group({

      nombre: ['', Validators.required],
      apellido: ['', Validators.required],
      edad: ['', Validators.required],
      pais: ['', Validators.required],
      ciudad: ['', Validators.required],
    })

  }
  guardar(){}
}
