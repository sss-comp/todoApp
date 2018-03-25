import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule }   from '@angular/forms';
import { HttpModule }    from '@angular/http';

import { AppComponent } from './app.component';
import { ToDoListComponentComponent } from './to-do-list-component/to-do-list-component.component';
import { TodoService } from './todo.service';


@NgModule({
  declarations: [
    AppComponent,
    ToDoListComponentComponent // Declaring custom component.
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [TodoService], // Providing service name.
  bootstrap: [AppComponent]
})
export class AppModule { }
