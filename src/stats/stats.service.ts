import { Model } from 'mongoose';
import { Injectable } from '@nestjs/common';
import { InjectModel } from '@nestjs/mongoose';
import { Stats, StatsDocument } from './schemas/stats.schema';
import { CreateStatsDto } from './dto/create-stats.dto';

@Injectable()
export class StatsService {  constructor(
    @InjectModel(Stats.name) private readonly statsModel: Model<StatsDocument>,
) {}

    async create(createStatsDto: CreateStatsDto): Promise<Stats> {
        const createdStats = await this.statsModel.create(createStatsDto);
        return createdStats;
    }

    async findAll(): Promise<Stats[]> {
        return this.statsModel.find().exec();
    }

    async findOne(id: string): Promise<Stats> {
        return this.statsModel.findOne({ _id: id }).exec();
    }
}
