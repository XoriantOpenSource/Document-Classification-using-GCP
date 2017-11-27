import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule, Response, Headers, RequestOptions } from '@angular/http';
import { AppComponent } from './app.component';
import { DocumentClassificationComponent } from './demo/document-classification/document-classification.component';
import { ClassificationServiceService } from './demo-service/classification-service.service';
@NgModule({
  declarations: [
    AppComponent,
    DocumentClassificationComponent
  ],
  imports: [
    BrowserModule,HttpModule
  ],
  providers: [ClassificationServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
