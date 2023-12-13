import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PaisService } from './services/pais/pais.service';
import { CiudadService } from './services/ciudad/ciudad.service';
import { PersonaService } from './services/persona/persona.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Frontend';
  personaForm: FormGroup
  pais: any   //inicializar
  ciudad: any
  personas: any;
  persona:any;


  constructor(
    public fb: FormBuilder,
    public paisService: PaisService,
    public ciudadService: CiudadService,
    public personaService: PersonaService,
  ) {

  }
  ngOnInit(): void {
    this.formulario();
    this.optenerPais();
    this.ObtenerListaPersonas()
  }

 private guardarPersona(): void {
    this.personaService.getSavePersona(this.personaForm.value).subscribe(
      resp => {
        if (this.personaForm) {         
          console.log(resp)
        }
        this.personas.push(resp);
        this.personaForm.reset();
      },
      error => {
        console.error('Error al guardar la persona:', error);
      }
    );
  }
  private optenerCiudad(): void {
    this.personaForm.get('pais').valueChanges.subscribe(value => {
      if (value && value.id) {
        this.ciudadService.getAllCiudadByPais(value.id).subscribe(
          resp => {
            this.ciudad = resp;
            console.log(resp);
            
          },
          error => {
            console.error(error);
          }
        );
      }
    });
  }
  
  private optenerPais(): void {
    this.paisService.getAllPaises().subscribe(resp => {
      this.pais = resp;
      console.log(resp)
    },
      error => { console.error() }
    );
  }
  private formulario(): void {
    this.personaForm = this.fb.group({
      nombre: ['', Validators.required],
      apellido: ['', Validators.required],
      edad: ['', Validators.required],
      pais: ['', Validators.required],
      ciudad: ['', Validators.required],
    });
    
  }
  private ObtenerListaPersonas(): void {
    this.personaService.getAllPersonas().subscribe(resp => {
      this.personas = resp;
    },
      error => (console.error())
    )
  }
  private deletePersona(persona): void {
    this.personaService.getDeletePersona(persona.id).subscribe(resp => {
      console.log(resp)
      if (resp) {
        this.personas.pop(persona.id)
      }
    })
  }
  private optenerPersona(persona):void {
    this.personaService.getpersona(persona.id).subscribe(resp =>{
      this.persona = resp;

      this.personaForm = this.fb.group({
        nombre: [this.persona.nombre],
        apellido: [this.persona.apellido],
        edad: [this.persona.edad],
        pais: [this.persona.pais],
        ciudad:[this.persona.ciudad],                
      });
      
        this.ciudadService.getAllCiudadByPais(this.persona.pais.id).subscribe(
          resp => {
            this.ciudad = resp;
            console.log(resp);          
          },
          error => {
            console.error(error);
          }
        );
      
      
    })
  }
  public getPersona(persona): void{
    this.optenerPersona(persona);
  }
  public eliminar(persona): void {
    this.deletePersona(persona)
  }
  public guardar(): void{
    this.guardarPersona();
  }
////////////////////////

  art={
    codigo:0 ,
    descripcion:"",
    precio:0
  }

  articulos = [{codigo:1, descripcion:'papas', precio:10.55},
               {codigo:2, descripcion:'manzanas', precio:12.10},
               {codigo:3, descripcion:'melon', precio:52.30},
               {codigo:4, descripcion:'cebollas', precio:17},
               {codigo:5, descripcion:'calabaza', precio:20},
              ];

  hayRegistros() {
    return this.articulos.length>0;              
  }

  borrar(codigo:number) {
    for(let x=0;x<this.articulos.length;x++)
      if (this.articulos[x].codigo==codigo)
      {
        this.articulos.splice(x,1);
        return;
      }
  }

  agregar() {
    if (this.art.codigo==0) {
      alert('Debe ingresar un código de articulo distinto a cero');
      return;
    }
    for(let x=0;x<this.articulos.length;x++)
    if (this.articulos[x].codigo==this.art.codigo)
    {
      alert('ya existe un articulo con dicho codigo');
      return;
    }        
    this.articulos.push({codigo:this.art.codigo,
                         descripcion:this.art.descripcion,
                         precio:this.art.precio });
    this.art.codigo=0;
    this.art.descripcion="";	
    this.art.precio=0;    
  }

  seleccionar(art: { codigo: number; descripcion: string; precio: number; }) {
    this.art.codigo=art.codigo;
    this.art.descripcion=art.descripcion;
    this.art.precio=art.precio;
  }

  modificar() {
    for(let x=0;x<this.articulos.length;x++)
      if (this.articulos[x].codigo==this.art.codigo)
      {
        this.articulos[x].descripcion=this.art.descripcion;
        this.articulos[x].precio=this.art.precio;
        return;
      }        
    alert('No existe el código de articulo ingresado');
  }
}
