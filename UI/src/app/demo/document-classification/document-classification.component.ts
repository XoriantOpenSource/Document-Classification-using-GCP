import { Component, OnInit ,ChangeDetectorRef } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import {Classification} from '../../class/Classification';
import {ClassificationServiceService} from '../../demo-service/classification-service.service';


@Component({
  selector: 'app-document-classification',
  templateUrl: './document-classification.component.html',
  styleUrls: ['./document-classification.component.css']
})
export class DocumentClassificationComponent implements OnInit {
  file:any;
  title :String = "Product Form";
  data :Classification[]=new Array();
  formData: FormData;

  constructor(private service : ClassificationServiceService,private changeDetectorRef: ChangeDetectorRef) { 
    this.formData=new FormData();
    this.data=[];
  }

  ngOnInit() {
  }
  selectFile(event : any){
    this.formData=new FormData();
    let target = event.target || event.srcElement;
    let files = target.files;
    console.log(files[0].name);
    this.formData.append('myfile', files[0]);
 }
 uploadFile() {
    // console.log("Going to save the Feed Back Object :complete"+JSON.stringify(result$));
    // console.log("this.formData "+this.formData.get('myfile'));

   this.service.uploadFile( this.formData ).subscribe((data:any) => {
     console.log(JSON.stringify(data));
     this.data=[];
     data.Data.forEach((data:Classification)=>this.data.push(data));
     console.log(JSON.stringify(this.data))
     this.changeDetectorRef.detectChanges();
  });
  
 }

}
