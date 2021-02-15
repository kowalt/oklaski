import {Component, OnInit} from '@angular/core';
import {FormControl} from "@angular/forms";
import {map, startWith} from "rxjs/operators";
import {Observable} from "rxjs";

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

  filteredOptionsCountry: Observable<string[]> | undefined;
  filteredOptionsDevices: Observable<string[]> | undefined;

  devicesRules: string[] = ["ALL"];
  countriesRules: string[] = ["ALL"];

  ngOnInit() {
    this.filteredOptionsCountry = this.countryFormControl.valueChanges.pipe(
      startWith(''),
      map(value => this._filter(value, this.countries))
    );

    this.filteredOptionsDevices = this.deviceFormControl.valueChanges.pipe(
      startWith(''),
      map(value => this._filter(value, this.devices))
    );
  }

  private _filter(value: string, list: string[]): string[] {
    const filterValue = value.toLowerCase();

    return list.filter(option => option.toLowerCase().indexOf(filterValue) === 0);
  }
}
