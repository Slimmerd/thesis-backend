import {Body, Controller, Get, Param, Post, UseGuards} from '@nestjs/common';
import {StatsService} from './stats.service';
import {CreateStatsDto} from './dto/create-stats.dto';
import {Stats} from './schemas/stats.schema';
import {StatsGuard} from "./guards/stats.guard";

@Controller('stats')
@UseGuards(StatsGuard)
export class StatsController {
    constructor(private readonly statsService: StatsService) {
    }

    @Post()
    async create(@Body() createStatsDto: CreateStatsDto) {
        await this.statsService.create(createStatsDto);
    }

    @Get()
    async findAll(): Promise<Stats[]> {
        return this.statsService.findAll();
    }

    @Get(':id')
    async findOne(@Param('id') id: string): Promise<Stats> {
        return this.statsService.findOne(id);
    }
}