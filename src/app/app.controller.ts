import {Body, Controller, Get, Post} from '@nestjs/common';
import { AppService } from './app.service';
import {CreateStatsDto} from "../stats/dto/create-stats.dto";

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  // @Post('/stats')
  // statsPostTest(@Body() createStatsDto: CreateStatsDto) {
  //   console.log(createStatsDto.uID);
  // }
  @Get()
  getHello(): string {
    return this.appService.getHello();
  }
}
