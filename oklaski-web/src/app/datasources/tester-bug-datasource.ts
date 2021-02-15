import {CollectionViewer, DataSource} from "@angular/cdk/collections";
import {TesterBug} from "../types/tester-bug";
import {BehaviorSubject, Observable, of} from "rxjs";
import {TesterService} from "../services/tester.service";
import {finalize} from "rxjs/operators";

export class TesterBugDataSource implements DataSource<TesterBug> {

  private testerBugSubject = new BehaviorSubject<TesterBug[]>([]);
  private loadingSubject = new BehaviorSubject<boolean>(false);
  public loading$ = this.loadingSubject.asObservable();

  constructor(private testersService: TesterService) {}

  connect(collectionViewer: CollectionViewer): Observable<TesterBug[]> {
    return this.testerBugSubject.asObservable();
  }

  disconnect(collectionViewer: CollectionViewer): void {
    this.testerBugSubject.complete();
    this.loadingSubject.complete();
  }

  loadTesterBug(countriesCriteria: string[], devicesCriteria: string[]) {
    this.loadingSubject.next(true);

    this.testersService.getTestersByBugs(countriesCriteria, devicesCriteria).pipe(
      finalize(() => this.loadingSubject.next(false))
    )
    .subscribe(testerBugs => this.testerBugSubject.next(testerBugs));
  }
}
