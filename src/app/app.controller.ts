import {Body, Controller, Get, Post, UseGuards} from '@nestjs/common';
import { AppService } from './app.service';
import {CreateStatsDto} from "../stats/dto/create-stats.dto";
import {StatsGuard} from "../stats/guards/stats.guard";

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  // @Post('/stats')
  // @UseGuards(StatsGuard)
  // statsPostTest(@Body() createStatsDto: CreateStatsDto) {
  //   console.log(createStatsDto.uID);
  // }
  @Get()
  getHello(): string {
    return this.appService.getHello();
  }
}
