import { Component, OnInit } from '@angular/core';

import { IExecutingJob } from './executingJob';
import { JobService } from '../jobs/job.service';

@Component({
  selector: 'app-executing-jobs',
  templateUrl: './executing-jobs.component.html',
  styleUrls: ['./executing-jobs.component.scss']
})
export class ExecutingJobsComponent implements OnInit {

  displayedColumnsExecutingJobs: string[] = ['triggerName', 'triggerGroup', 'jobName', 'jobGroup', 'jobClass', 'fireTime', 'nextExecutionTime']

  userId: number;
  executingJobs: IExecutingJob[] = [];
  errorMessage = '';
  constructor(private jobService: JobService) {}

  ngOnInit() {
    this.jobService.getExecutingJobs().subscribe(
      perms => {
        this.executingJobs = perms;
      },
      error => this.errorMessage = <any>error
    );
  }
}