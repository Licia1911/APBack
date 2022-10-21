import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { BannerComponent } from './components/banner/banner.component';
import { AcercaComponent } from './components/acerca/acerca.component';
import { EducacionComponent } from './components/acerca/educacion/educacion.component';
import { ExperienciaComponent } from './components/acerca/experiencia/experiencia.component';
import { SkillsComponent } from './components/skills/skills.component';
import { ProyectosComponent } from './components/proyectos/proyectos.component';
import { FooterComponent } from './components/footer/footer.component';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { SkillsFComponent } from './components/skills/skills-f/skills-f.component';
import { SkillsBComponent } from './components/skills/skills-b/skills-b.component';
import { SkillsSComponent } from './components/skills/skills-s/skills-s.component';
import { InterceptorService } from './services/interceptor.service';
import { PortfolioComponent } from './components/portfolio/portfolio.component';
import { AcercaService } from './services/acerca.service';
import { AutenticacionService } from './services/autenticacion.service';
import { EducacionService } from './services/educacion.service';
import { ExperienciaService } from './services/experiencia.service';
import { NavbarService } from './services/navbar.service';
import { ProyectosService } from './services/proyectos.service';
import { SkillsbService } from './services/skillsb.service';
import { SkillsfService } from './services/skillsf.service';
import { SkillssService } from './services/skillss.service';
import { BannerService } from './services/banner.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DragDropModule } from '@angular/cdk/drag-drop';




@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    BannerComponent,
    AcercaComponent,
    EducacionComponent,
    ExperienciaComponent,
    SkillsComponent,
    ProyectosComponent,
    FooterComponent,
    SkillsFComponent,
    SkillsBComponent,
    SkillsSComponent,
    PortfolioComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    DragDropModule,
  ],
  providers: [
    AcercaService,
    AutenticacionService,
    BannerService,
    EducacionService,
    ExperienciaService,
    NavbarService,
    ProyectosService,
    SkillsbService,
    SkillsfService,
    SkillssService,
    InterceptorService,
    { provide: HTTP_INTERCEPTORS, useClass: InterceptorService, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
