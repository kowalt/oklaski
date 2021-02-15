import {Component, OnInit} from '@angular/core';
import {FormControl} from "@angular/forms";
import {TesterService} from "./services/tester.service";
import {TesterBugDataSource} from "./datasources/tester-bug-datasource";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'oklaski-web';

  countryFormControl = new FormControl();
  deviceFormControl = new FormControl();
  countries: string[] = ['US', 'GB', 'JP'];
  devices: string[] = ['iPhone 4',
    'iPhone 4S',
    'iPhone 5',
    'Galaxy S3',
    'Galaxy S4',
    'Nexus 4',
    'Droid Razor',
    'Droid DNA',
    'HTC One',
    'iPhone 3'
  ];

  devicesCriteria: string[] = ['ALL'];
  countriesCriteria: string[] = ['ALL'];

  displayedColumns = ['id', 'firstName', 'lastName', 'country', 'numOfBugs'];

  dataSource: TesterBugDataSource;

  constructor (private testerService: TesterService) {
    this.dataSource = new TesterBugDataSource(this.testerService);
  }

  ngOnInit() {
    this.dataSource.loadTesterBug(this.countriesCriteria, this.devicesCriteria);
  }

  onSearch() {
    this.countriesCriteria = (this.countryFormControl.value && this.countryFormControl.value.length) ? this.countryFormControl.value : ['ALL'];
    this.devicesCriteria = (this.deviceFormControl.value && this.deviceFormControl.value.length) ? this.deviceFormControl.value : ['ALL'];

    this.dataSource.loadTesterBug(this.countriesCriteria, this.devicesCriteria)
  }
}
